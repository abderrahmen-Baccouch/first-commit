package com.example.premierepage

import com.example.premierepage.model.*
import com.example.premierepage.model.Defit
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap


import okhttp3.ResponseBody

import retrofit2.http.POST

import retrofit2.http.Multipart




interface RetrofitInterface {
    /**User*/
    @POST("/user/signup")
    fun executeSignup(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @POST("/user/signin")
    fun executeLogin(
        @Body map: HashMap<String?, String?>?
    ): Call<LoginResult?>?

    @PATCH("user/save")
    fun executeSave(
        @Body map: HashMap<String?, String?>?,
        @Header("authorization") authHeader: String?
    ): Call<Void?>?

    // @POST("/user/logout")
    // fun executeLogout(): Call<Void>?





    /**--------------------------------------------------Aliment------------------------------------------------------------*/
    @POST("aliment/addAliment")
    fun executeAddAliment(
        @Body map:HashMap<String?,String?>?,
        @Header("authorization") authHeader: String?
    ):Call<Void?>?

    @GET("aliment/allAliments")
    fun executeAllAliments(
        @Header("authorization") authHeader: String?
    ):Call<MutableList<Aliments>>

    @PUT("aliment/updateAliment/{id}")
    fun executeUpdateAliment(
        @Body map:HashMap<String?,String?>?,
        @Path("id") id:String?
    ):Call<Void?>?

    @DELETE("aliment/delete/{id}")
    fun executeDeleteAliment(@Path("id") id:String?
    ):Call<Void?>?



    /**-----------------------------------------------notre aliment------------------------------------------------------------*/
    @GET("notrealiment/allAliments")
    fun executeAllNotreAliments()
            :Call<MutableList<Aliments>>

    @POST("notrealiment/addAliment")//---------------Admin
    fun executeAddNotreAliment(
        @Body map:HashMap<String?,String?>?
    ):Call<Void?>?

    @PUT("notrealiment/updateAliment/{id}")//---------------Admin
    fun executeUpdateNotreAliment(
        @Body map:HashMap<String?,String?>?,
        @Path("id") id:String?
    ):Call<Void?>?

    @DELETE("notrealiment/delete/{id}")//---------------Admin
    fun executeDeleteNotreAliment(
        @Path("id") id:String?)
            :Call<Void?>?




    /**------------------------------------------Exercice-------------------------------------*/

    @GET("exercice/allExercices")
    fun executeAllExercices():Call<MutableList<Exercices>>

    //add
    //@Multipart
    @POST("exercice/addExercice")
    fun executeAddExercice(
        @Body map: HashMap<String?, String?>?,
        /* @Part image: MultipartBody.Part,
        @Part("myFile") name:RequestBody*/
    )
            :Call<Void>

    //update
    @PUT("exercice/updateExercice/{idexercice}")
    fun executeUpdateExercice(
        @Body map:HashMap<String?,String?>?,
        @Path("idexercice") idexercice:String?
    ):Call<Void>

    //delete

    @DELETE("exercice/delete/{id}")
    fun executeDeleteExercice(
        @Path("id") id:String?
    ):Call<Void>



    @Multipart
    @POST("/exercice/upload")
    fun postImage(@Part image: MultipartBody.Part?,
                  @Part("upload") name: RequestBody?,
    ): Call<Image>?






    /**-------------------------------------------------ExerciceTermine------------------------------------------------*/
    @POST("exercicetermine/addExerciceTermine")
    fun executeAddExerciceTermine(
        @Header("authorization") authHeader: String?,
        @Body map:HashMap<String?,String?>?
    )
            :Call<Void?>?

    @POST("exercicetermine/allExerciceTermine")
    fun executeAllExerciceTermine(
        @Body map:HashMap<String?,String?>?,
        @Header("authorization") authHeader: String?
    ):Call<MutableList<Exercices>>

    @POST("exercicetermine/getCaloriesBrulee")
    fun executeGetCaloriesBrulee(@Body map:HashMap<String?,String?>?,
                                 @Header("authorization") authHeader: String?)
            :Call<Exercices>

    @DELETE("exercicetermine/deleteExerciceTermine/{id}")
    fun executeDeleteExerciceTermine( @Path("id") id:String?)
    :Call<Void>

    /**----------------------------------------------------Recette-------------------------------------------*/

    @GET("recette/allRecettes")
    fun executeAllRecettes(
        @Header("authorization") authHeader: String?)
            :Call<MutableList<RecetteX>>

    @POST("recette/addRecette")
    fun executeAddRecette(
        @Body map:HashMap<String?,String?>?,
        @Header("authorization") authHeader: String?)
            :Call<Recette>

    @POST("recette/addIngredient/{idrecette}/{idaliment}")
    fun executeAddIngredient(@Header("authorization") authHeader: String?,
                             @Path("idrecette") idrecette:String?,
                             @Path("idaliment") idaliment:String?,
                             @Body map:HashMap<String?,String?>?)
            :Call<RecetteX>


    @PUT("recette/save/{idrecette}")
    fun executeSaveRecette(@Path("idrecette") idrecette: String?,@Body map:HashMap<String?,String?>?)
            :Call<Void>

    @GET("recette/allIngredients/{idrecette}")
    fun executeAllIngredients(@Path("idrecette") idrecette: String?)
            :Call<MutableList<Aliments>>

    @DELETE("recette/deleteIngredient/{idrecette}/{indiceingredient}")
    fun executeDeleteIngredient(@Path("idrecette") idrecette: String?,
                                @Path("indiceingredient") indiceingredient: String?):Call<Void>

    @DELETE("recette/deleteRecette/{idrecette}")
    fun executeDeleteRecette(@Path("idrecette") idrecette: String?, )
    :Call<Void>


    /**--------------------------------------------notre repas -----------------------------------------------------------*/

    @POST("notrerepas/allrepas")
    fun executeAllRepas(@Body map:HashMap<String?,String?>?)//body feha typeRepas
            :Call<MutableList<RecetteX>>


    @POST("notrerepas/addRepas")
    fun executeAddRepas(
        @Body map:HashMap<String?,String?>?)
            :Call<Recette>


    @POST("notreRepas/addIngredient/{idrecette}/{idaliment}")
    fun executeAddIngredientAdmin(@Path("idrecette") idrecette:String?,
                                  @Path("idaliment") idaliment:String?,
                                  @Body map:HashMap<String?,String?>?)
            :Call<RecetteX>





    /**--------------------------------------------------Diary-------------------------------------------------------------*/

    @POST("/diary/createBreakfast")
    fun executeCreateBreakfast(
        @Header("authorization") authHeader: String?,
        @Body map:HashMap<String?,String?>?
    )
            :Call<BreakfastX>

    @POST("/diary/createDinner")
    fun executeCreateDinner(
        @Header("authorization") authHeader: String?,
        @Body map:HashMap<String?,String?>?
    )
            :Call<BreakfastX>

    @POST("/diary/createLunch")
    fun executeCreateLunch(
        @Header("authorization") authHeader: String?,
        @Body map:HashMap<String?,String?>?
    )
            :Call<BreakfastX>

    @POST("diary/addBreakfast/{idrecette}")
    fun executeAddBreakfast(
        @Header("authorization") authHeader: String?,
        @Path("idrecette") idrecette: String?,
        @Body map:HashMap<String?,String?>?
    ):Call<Void>

    @POST("diary/addDinner/{idrecette}")
    fun executeAddDinner(
        @Header("authorization") authHeader: String?,
        @Path("idrecette") idrecette: String?,
        @Body map:HashMap<String?,String?>?
    ):Call<Void>

    @POST("diary/addLunch/{idrecette}")
    fun executeAddLunch(
        @Header("authorization") authHeader: String?,
        @Path("idrecette") idrecette: String?,
        @Body map:HashMap<String?,String?>?
    ):Call<Void>


    @POST("diary/allBreakfast")
    fun executeAllBreakfast(@Header("authorization") authHeader: String?,
                            @Body map:HashMap<String?,String?>?)
            :Call<MutableList<BreakfastX>>

    @POST("diary/allDinner")
    fun executeAllDinner(@Header("authorization") authHeader: String?,
                         @Body map:HashMap<String?,String?>?)
            :Call<MutableList<BreakfastX>>

    @POST("diary/allLunch")
    fun executeAllLunch(@Header("authorization") authHeader: String?,
                        @Body map:HashMap<String?,String?>?)
            :Call<MutableList<BreakfastX>>



    @POST("diary/caloriesConsome")
    fun executeGetCaloriesConsome(@Body map:HashMap<String?,String?>?,
                                  @Header("authorization") authHeader: String?)
            :Call<BreakfastX>//zid thabet feha



    /**-----------------------------------------------Defit--------------------------------------------------------*/

    @POST("defit/addDefit")
    fun executeAddDefit(
        @Body map:HashMap<String?,String?>?)
            :Call<Void>

    @POST("defit/addEtape/{iddefit}")
    fun executeAddEtape(
        @Body map: HashMap<String?, String?>?,
        @Path("iddefit") iddefit: String?,
    ):Call<Void>

    @GET("defit/allDefit")
    fun executeAllDefit()
            :Call<MutableList<Defit>>

    @GET("defit/allEtapes/{iddefit}")
    fun  executeAllEtapes(@Path("iddefit") iddefit: String?)
            :Call<MutableList<String>>




    @GET("defit3/allDefit")
    fun executeAllDefit3()
            :Call<MutableList<Defit>>

    @GET("defit3/getDefit/{iddefit}")
    fun executeGetDefit(@Path("iddefit") iddefit: String?,
    )
            :Call<Defit>

    /***********************************Task**********************************************/

    @POST("task/addTask")
    fun executeAddTask(@Header("authorization") authHeader: String?,
                       @Body map:HashMap<String?,String?>?)
    :Call<Void>//momken tetbadel ki bech naamlou notification

    @GET("task/allTasks")
    fun executeAllTasks(@Header("authorization") authHeader: String?,)
    :Call<MutableList<Task>>

    @DELETE("task/deleteTask/{id}")
    fun executeDeleteTask(@Path("id") id: String?)
            :Call<Void>




    /***********************************Eau**********************************************/

    @POST("eau/addEau")
    fun executeAddEau(@Header("authorization") authHeader: String?,
                      @Body map:HashMap<String?,String?>?)
    :Call<Void>

    @GET("eau/alleau")
    fun executeAllEau(@Header("authorization") authHeader: String?,)
    :Call<MutableList<Eau>>


    @DELETE("eau/deleteEau/{idEau}")
    fun executeDeleteEau(@Path("idEau") iddefit: String?)
    :Call<Void>






}