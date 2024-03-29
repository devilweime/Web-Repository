package com.b2c.mapper;

import com.b2c.model.ScoreRule;
import com.b2c.model.ScoreRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreRuleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    long countByExample(ScoreRuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int deleteByExample(ScoreRuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int insert(ScoreRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int insertSelective(ScoreRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    List<ScoreRule> selectByExample(ScoreRuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    ScoreRule selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") ScoreRule record, @Param("example") ScoreRuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int updateByExample(@Param("record") ScoreRule record, @Param("example") ScoreRuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(ScoreRule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_rule
     *
     * @mbg.generated Thu Jul 27 20:07:29 GMT+08:00 2017
     */
    int updateByPrimaryKey(ScoreRule record);
}