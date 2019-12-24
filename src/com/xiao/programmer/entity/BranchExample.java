package com.xiao.programmer.entity;

import java.util.ArrayList;
import java.util.List;

public class BranchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BranchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andBranchidIsNull() {
            addCriterion("branchId is null");
            return (Criteria) this;
        }

        public Criteria andBranchidIsNotNull() {
            addCriterion("branchId is not null");
            return (Criteria) this;
        }

        public Criteria andBranchidEqualTo(String value) {
            addCriterion("branchId =", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidNotEqualTo(String value) {
            addCriterion("branchId <>", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidGreaterThan(String value) {
            addCriterion("branchId >", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidGreaterThanOrEqualTo(String value) {
            addCriterion("branchId >=", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidLessThan(String value) {
            addCriterion("branchId <", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidLessThanOrEqualTo(String value) {
            addCriterion("branchId <=", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidLike(String value) {
            addCriterion("branchId like", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidNotLike(String value) {
            addCriterion("branchId not like", value, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidIn(List<String> values) {
            addCriterion("branchId in", values, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidNotIn(List<String> values) {
            addCriterion("branchId not in", values, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidBetween(String value1, String value2) {
            addCriterion("branchId between", value1, value2, "branchid");
            return (Criteria) this;
        }

        public Criteria andBranchidNotBetween(String value1, String value2) {
            addCriterion("branchId not between", value1, value2, "branchid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNull() {
            addCriterion("courseId is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(String value) {
            addCriterion("courseId =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(String value) {
            addCriterion("courseId <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(String value) {
            addCriterion("courseId >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(String value) {
            addCriterion("courseId >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(String value) {
            addCriterion("courseId <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(String value) {
            addCriterion("courseId <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLike(String value) {
            addCriterion("courseId like", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotLike(String value) {
            addCriterion("courseId not like", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<String> values) {
            addCriterion("courseId in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<String> values) {
            addCriterion("courseId not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(String value1, String value2) {
            addCriterion("courseId between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(String value1, String value2) {
            addCriterion("courseId not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andSelectedIsNull() {
            addCriterion("selected is null");
            return (Criteria) this;
        }

        public Criteria andSelectedIsNotNull() {
            addCriterion("selected is not null");
            return (Criteria) this;
        }

        public Criteria andSelectedEqualTo(Integer value) {
            addCriterion("selected =", value, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedNotEqualTo(Integer value) {
            addCriterion("selected <>", value, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedGreaterThan(Integer value) {
            addCriterion("selected >", value, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedGreaterThanOrEqualTo(Integer value) {
            addCriterion("selected >=", value, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedLessThan(Integer value) {
            addCriterion("selected <", value, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedLessThanOrEqualTo(Integer value) {
            addCriterion("selected <=", value, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedIn(List<Integer> values) {
            addCriterion("selected in", values, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedNotIn(List<Integer> values) {
            addCriterion("selected not in", values, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedBetween(Integer value1, Integer value2) {
            addCriterion("selected between", value1, value2, "selected");
            return (Criteria) this;
        }

        public Criteria andSelectedNotBetween(Integer value1, Integer value2) {
            addCriterion("selected not between", value1, value2, "selected");
            return (Criteria) this;
        }

        public Criteria andLimitedIsNull() {
            addCriterion("limited is null");
            return (Criteria) this;
        }

        public Criteria andLimitedIsNotNull() {
            addCriterion("limited is not null");
            return (Criteria) this;
        }

        public Criteria andLimitedEqualTo(Integer value) {
            addCriterion("limited =", value, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedNotEqualTo(Integer value) {
            addCriterion("limited <>", value, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedGreaterThan(Integer value) {
            addCriterion("limited >", value, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedGreaterThanOrEqualTo(Integer value) {
            addCriterion("limited >=", value, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedLessThan(Integer value) {
            addCriterion("limited <", value, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedLessThanOrEqualTo(Integer value) {
            addCriterion("limited <=", value, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedIn(List<Integer> values) {
            addCriterion("limited in", values, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedNotIn(List<Integer> values) {
            addCriterion("limited not in", values, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedBetween(Integer value1, Integer value2) {
            addCriterion("limited between", value1, value2, "limited");
            return (Criteria) this;
        }

        public Criteria andLimitedNotBetween(Integer value1, Integer value2) {
            addCriterion("limited not between", value1, value2, "limited");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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