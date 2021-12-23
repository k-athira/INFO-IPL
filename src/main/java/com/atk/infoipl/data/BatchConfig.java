package com.atk.infoipl.data;

import javax.sql.DataSource;

import com.atk.infoipl.model.Team;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@Configurable
@EnableBatchProcessing
public class BatchConfig {

    private final String[] TEAM_TABLE = {"external_id", "codeName", "fullName", "status",
        "intro_year", "last_played_year"
    };

    private String TEAM_SQL = "INSERT INTO TEAM (EXTERNAL_ID, CODE_NAME, FULL_NAME, STATUS, INTRO_YEAR, LAST_PLAYED_YEAR)"
        + " VALUES (:external_id, :codeName, :fullName, :status, :intro_year, :last_played_year)";

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<TeamInput> reader() {
        return new FlatFileItemReaderBuilder<TeamInput>()
                .name("TeamItemReader")
                .resource(new ClassPathResource("Teams.csv"))
                .delimited()
                .names(TEAM_TABLE)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<TeamInput>() {
                    {
                        setTargetType(TeamInput.class);
                    }
                }).linesToSkip(1)
                .build();
    }

    @Bean
    public TeamDataProcessor processor() {
        return new TeamDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Team> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Team>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(TEAM_SQL)
                .dataSource(dataSource).build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory
            .get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Team> writer) {
        return stepBuilderFactory
            .get("step1")
            .<TeamInput, Team>chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }


    
}
