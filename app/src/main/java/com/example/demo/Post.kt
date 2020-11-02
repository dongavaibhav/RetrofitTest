package com.example.demo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("salary")
    @Expose
    var salary: String? = null

    @SerializedName("age")
    @Expose
    var age: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    override fun toString(): String {
        return "Post{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}'
    }
}