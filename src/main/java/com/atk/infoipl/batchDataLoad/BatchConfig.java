package com.atk.infoipl.batchDataLoad;

import javax.sql.DataSource;

import com.atk.infoipl.model.Match;
import com.atk.infoipl.model.Team;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private String FILE_NAME = "match_data.csv";

    private final String[] CSV_HEADER = { "id","city","date","player_of_match","venue","neutral_venue",
        "team1","team2","toss_winner","toss_decision","winner","result","result_margin","eliminator",
        "method","umpire1","umpire2"
    };

    private String INSERT_TEAM_SQL = "INSERT INTO TEAM (NAME, STATUS, INTRO_YEAR, LAST_PLAYED_YEAR, TOTAL_MATCH, TOTAL_WINS, NO_LOSSES, NO_DRAW, IS_CURRENT_CHAMPION)"
        + " VALUES (:name, :status, :intro_year, :last_played_year, :totalMatch, :totalWins, :noLosses, :noDraw, :is_current_champion)";

    private String DIST_TEAM_QUERY = "SELECT DISTINCT TEAM1NAME FROM MATCH";

    private String MATCH_SQL = "INSERT INTO MATCH ("
    + " TEAM1_ID, TEAM2_ID, DATE, VENUE, TOSS_WINNER_ID, OPTED_FOR, WINNER_ID, MAN_OF_THE_MATCH,"
    + " RESULT, RESULT_MARGIN, TEAM1NAME, TEAM2NAME, WINNER_NAME, TOSS_WINNER_NAME)"
    + " VALUES (:team1, :team2, :date, :venue, :tossWinner, :optedFor, :winner, :man_of_the_match,"
    + " :result, :resultMargin, :team1Name, :team2Name, :winnerName, :tossWinnerName)";

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<MatchInput> reader() {
        return new FlatFileItemReaderBuilder<MatchInput>()
                .name("TeamItemReader")
                .resource(new ClassPathResource(FILE_NAME))
                .delimited()
                .names(CSV_HEADER)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {
                    {
                        setTargetType(MatchInput.class);
                    }
                }).linesToSkip(1)
                .build();
    }

    @Bean
    public JdbcCursorItemReader<Team> distMatchReader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Team>()
                .dataSource(dataSource)
                .name("distMatchReader")
                .sql(DIST_TEAM_QUERY)
                .rowMapper(new DistTeamRowMapper())
                .build();

    }

    @Bean
    public TeamDataProcessor processorTeamData(){
        return new TeamDataProcessor();
    }

    @Bean
    public MatchDataProcessor processorMatchData() {
        return new MatchDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writerMatch(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(MATCH_SQL)
                .dataSource(dataSource).build();
    }

    @Bean
    public JdbcBatchItemWriter<Team> writerTeam(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Team>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(INSERT_TEAM_SQL)
                .dataSource(dataSource).build();
    }


    @Bean
    public Job dataLoadJob(JobCompletionNotificationListener listener, Step teamLoad, Step matchLoad) {
        return jobBuilderFactory
            .get("dataLoadJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .start(matchLoad)
            .next(teamLoad)
            .build();
    }


    @Bean
    public Step teamLoad(JdbcCursorItemReader<Team> distMatchReader, JdbcBatchItemWriter<Team> writerTeam) {
        return stepBuilderFactory
            .get("teamLoad")
            .<Team, Team>chunk(10)
            .reader(distMatchReader)
            .processor(processorTeamData())
            .writer(writerTeam)
            .build();
    }

    @Bean
    public Step matchLoad(JdbcBatchItemWriter<Match> writerMatch) {
        return stepBuilderFactory
            .get("step2")
            .<MatchInput, Match>chunk(10)
            .reader(reader())
            .processor(processorMatchData())
            .writer(writerMatch)
            .build();
    }
    
}
