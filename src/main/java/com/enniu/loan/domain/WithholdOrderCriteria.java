package com.enniu.loan.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithholdOrderCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public WithholdOrderCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdIsNull() {
            addCriterion("loan_order_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdIsNotNull() {
            addCriterion("loan_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdEqualTo(Integer value) {
            addCriterion("loan_order_id =", value, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdNotEqualTo(Integer value) {
            addCriterion("loan_order_id <>", value, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdGreaterThan(Integer value) {
            addCriterion("loan_order_id >", value, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_order_id >=", value, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdLessThan(Integer value) {
            addCriterion("loan_order_id <", value, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("loan_order_id <=", value, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdIn(List<Integer> values) {
            addCriterion("loan_order_id in", values, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdNotIn(List<Integer> values) {
            addCriterion("loan_order_id not in", values, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("loan_order_id between", value1, value2, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andLoanOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_order_id not between", value1, value2, "loanOrderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andDepositCardIsNull() {
            addCriterion("deposit_card is null");
            return (Criteria) this;
        }

        public Criteria andDepositCardIsNotNull() {
            addCriterion("deposit_card is not null");
            return (Criteria) this;
        }

        public Criteria andDepositCardEqualTo(Long value) {
            addCriterion("deposit_card =", value, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardNotEqualTo(Long value) {
            addCriterion("deposit_card <>", value, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardGreaterThan(Long value) {
            addCriterion("deposit_card >", value, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardGreaterThanOrEqualTo(Long value) {
            addCriterion("deposit_card >=", value, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardLessThan(Long value) {
            addCriterion("deposit_card <", value, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardLessThanOrEqualTo(Long value) {
            addCriterion("deposit_card <=", value, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardIn(List<Long> values) {
            addCriterion("deposit_card in", values, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardNotIn(List<Long> values) {
            addCriterion("deposit_card not in", values, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardBetween(Long value1, Long value2) {
            addCriterion("deposit_card between", value1, value2, "depositCard");
            return (Criteria) this;
        }

        public Criteria andDepositCardNotBetween(Long value1, Long value2) {
            addCriterion("deposit_card not between", value1, value2, "depositCard");
            return (Criteria) this;
        }

        public Criteria andTempCardIsNull() {
            addCriterion("temp_card is null");
            return (Criteria) this;
        }

        public Criteria andTempCardIsNotNull() {
            addCriterion("temp_card is not null");
            return (Criteria) this;
        }

        public Criteria andTempCardEqualTo(Long value) {
            addCriterion("temp_card =", value, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardNotEqualTo(Long value) {
            addCriterion("temp_card <>", value, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardGreaterThan(Long value) {
            addCriterion("temp_card >", value, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardGreaterThanOrEqualTo(Long value) {
            addCriterion("temp_card >=", value, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardLessThan(Long value) {
            addCriterion("temp_card <", value, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardLessThanOrEqualTo(Long value) {
            addCriterion("temp_card <=", value, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardIn(List<Long> values) {
            addCriterion("temp_card in", values, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardNotIn(List<Long> values) {
            addCriterion("temp_card not in", values, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardBetween(Long value1, Long value2) {
            addCriterion("temp_card between", value1, value2, "tempCard");
            return (Criteria) this;
        }

        public Criteria andTempCardNotBetween(Long value1, Long value2) {
            addCriterion("temp_card not between", value1, value2, "tempCard");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table withhold_order
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 01 11:26:25 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table withhold_order
     *
     * @mbggenerated Wed Oct 01 11:26:25 CST 2014
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}