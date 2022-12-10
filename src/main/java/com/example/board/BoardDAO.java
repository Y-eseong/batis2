package com.spring.board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    SqlSession sqlSession;

    public int insertBoard(BoardVO vo){
        int insert_result = sqlSession.insert("Board.insertBoard",vo);
        return insert_result;
    }

    public int updateBoard(BoardVO vo) {
        int update_result = sqlSession.update("Board.updateBoard",vo);
        return update_result;
    }

    public int deleteBoard(int seq) {
        int delete_result = sqlSession.delete("Board.deleteBoard",seq);
        return delete_result;
    }

    public BoardVO getBoard(int seq){
        BoardVO one = sqlSession.selectOne("Board.getBoard",seq);
        return one;
    }

    public List<BoardVO> getBoardList(){
        List<BoardVO> list = sqlSession.selectList("Board.getBoardList");
        return list;
    }
//    class BoardRowMapper implements RowMapper<BoardVO> {
//        @Override
//        public BoardVO mapRow(ResultSet rs, int rowNum)throws SQLException{
//            BoardVO vo = new BoardVO();
//            vo.setSeq(rs.getInt("seq"));
//            vo.setTitle(rs.getString("title"));
//            vo.setWriter(rs.getString("writer"));
//            vo.setContent(rs.getString("content"));
//            vo.setCategory(rs.getString("category"));
//            vo.setRegdate(rs.getDate("regdate"));
//            vo.setTopic(rs.getString("topic"));
//
//            return vo;
//
//        }
//    }
}
