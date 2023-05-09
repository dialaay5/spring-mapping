package spring;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
    public class Order implements Serializable {

        public Order() {

        }

        public Order(Integer id, String name) {
            this.id = id;
            this.customerName = name;
        }

        public Integer id;

        @JsonProperty(value = "name")
        public String customerName;

    }

