package top.lvjp.multidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "top.lvjp.multidatasource.mapper.data1", sqlSessionTemplateRef = "data1SqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "data1DataSource")
    @ConfigurationProperties(prefix = "spring.data1.datasource")
    @Primary        // 声明该数据源为主数据源
    public DataSource data1DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "data1SqlSessionFactory")
    @Primary
    public SqlSessionFactory data1SqlSessionFactory(@Qualifier("data1DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/data1/*xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "data1TransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("data1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("data1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate data1SqlSessionTemplate(@Qualifier("data1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
