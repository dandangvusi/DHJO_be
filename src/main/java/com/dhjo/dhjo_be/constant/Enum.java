package com.dhjo.dhjo_be.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Enum {
    public enum EDUCATION implements PersistableEnum<String> {
        SECONDARY_SCHOOL("SECONDARY_SCHOOL"),
        HIGH_SCHOOL("HIGH_SCHOOL"),
        COLLEGE("COLLEGE"),
        BACHELOR("BACHELOR");
        private String value;
        private EDUCATION(String value){
            this.value = value;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }
    public enum GENDER implements PersistableEnum<String> {
        MALE("MALE"),
        FEMALE("FEMALE"),
        OTHER("OTHER");
        private String value;
        private GENDER(String value){
            this.value = value;
        }
        @Override
        public String getValue() {
            return this.value;
        }
    }
    public enum ROLE implements PersistableEnum<String> {
        ROLE_ADMIN("ROLE_ADMIN"),
        ROLE_OWNER("ROLE_OWNER"),
        ROLE_HELPER("ROLE_HELPER");
        private String value;
        private ROLE(String value){
            this.value = value;
        }
        @Override
        public String getValue() {
            return this.value;
        }
    }
    public enum SKILL implements PersistableEnum<String> {
        ENGLISH("ENGLISH"),
        COOKING("COOKING"),
        LAUNDRY("LAUNDRY");
        private String value;
        private SKILL(String value){
            this.value = value;
        }
        @Override
        public String getValue() {
            return this.value;
        }
    }
    public enum HOUSE_TYPE implements PersistableEnum<String> {
        HOUSE("HOUSE"),
        APARTMENT("APARTMENT");
        private String value;
        private HOUSE_TYPE(String value){
            this.value = value;
        }
        @Override
        public String getValue() {
            return this.value;
        }
    }
    public enum PERIOD implements PersistableEnum<String> {
        DAY("DAY"),
        WEEK("WEEK"),
        MONTH("MONTH");
        private String value;
        private PERIOD(String value){
            this.value = value;
        }
        @Override
        public String getValue() {
            return this.value;
        }
    }
}
