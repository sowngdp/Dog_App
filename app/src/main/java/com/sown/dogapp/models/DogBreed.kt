package com.sown.dogapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DogBreed {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("life_span")
    @Expose
    var life_span: String? = null

    @SerializedName("origin")
    @Expose
    var origin : String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null


}