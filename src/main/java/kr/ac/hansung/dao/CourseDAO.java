package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

//bean 으로 등록
//다음으로 패키지 명시해줘야함
@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		//dataSource 의존성 주입
	}
	public int getRowCount() {
		String sqlStatement = "Select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

	}

	
	public int getSumGrade() {
		String sqlStatement = "Select sum(grades) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	public Course getCourse(String code) {
		//이름을 받아서 Offer 객체 리턴
		String sqlStatement = "select * from course where code=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {code},
				new RowMapper<Course>(){
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setCode(rs.getString("code"));
						course.setDivi(rs.getString("divi"));
						course.setGrades(rs.getInt("grades"));
						course.setSeme(rs.getInt("seme"));
						course.setTitle(rs.getString("title"));
						course.setYear(rs.getInt("year"));
						
						return course;
					}
			
		});
		
	}
	public List<Course> getCourseDivi() {
		String sqlStatement = "select divi, sum(grades) from course group by divi";
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Course>(){
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setGrades(rs.getInt("sum(grades)"));
						course.setDivi(rs.getString("divi"));
						
						
						return course;
					}
			
		});
		
	}
	public List<Course> getCourseYearSeme() {
		String sqlStatement = "select year, seme, sum(grades) from course group by year,seme order by year,seme;";
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Course>(){
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setGrades(rs.getInt("sum(grades)"));
						course.setSeme(rs.getInt("seme"));
						course.setYear(rs.getInt("year"));
						
						return course;
					}
			
		});
		
	}
	public List<Course> getCoursesYearSeme(int year, int seme) {
		//이름을 받아서 Offer 객체 리턴
		String sqlStatement = "select * from course where year = ? and seme=?";
		return jdbcTemplate.query(sqlStatement,new Object[] {year, seme},
				new RowMapper<Course>(){
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setCode(rs.getString("code"));
						course.setDivi(rs.getString("divi"));
						course.setGrades(rs.getInt("grades"));
						course.setSeme(rs.getInt("seme"));
						course.setTitle(rs.getString("title"));
						course.setYear(rs.getInt("year"));
					
						return course;
					}
			
		});
		
	}
	public List<Course> getCourses() {
		//이름을 받아서 Offer 객체 리턴
		String sqlStatement = "select * from course where code=?";
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Course>(){
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setCode(rs.getString("code"));
						course.setDivi(rs.getString("divi"));
						course.setGrades(rs.getInt("grades"));
						course.setSeme(rs.getInt("seme"));
						course.setTitle(rs.getString("title"));
						course.setYear(rs.getInt("year"));
					
						return course;
					}
			
		});
		
	}
	public boolean insert(Course course) {
		//int id = offer.getId();
		
		String code = course.getCode();
		String divi = course.getDivi();
		int grades = course.getGrades();
		int seme = course.getSeme();
		String title = course.getTitle();
		int year = course.getYear();
		
		String sql = "insert into course (year, seme, code, title, divi, grades) values (?,?,?,?,?,?)";
		return 	(jdbcTemplate.update(sql, new Object[] {year, seme, code, title, divi, grades})==1);
	}
	/*public boolean update(Course course) {
		String code = course.getCode();
		String divi = course.getDivi();
		int grades = course.getGrades();
		int seme = course.getSeme();
		String title = course.getTitle();
		int year = course.getYear();
		
		//String sql = "upadate course set code?(year, seme, code, title, divi, grades) values (?,?,?,?,?,?)";
		return 	(jdbcTemplate.update(sql, new Object[] {year, seme, code, title, divi, grades})==1);
		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sql = "update offer set name = ?, email = ?, text = ? where id=?";
		return 	(jdbcTemplate.update(sql, new Object[] {name, email, text, id})==1);
	}*/
	
	public boolean delete(String code) {
		String sql = "delete from course where code=?";
		return (jdbcTemplate.update(sql, new Object[] {code})==1);
	}
}
