package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import e.m7eds.jokeslibrary.Joke;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)

public class MyEndpoint {

    @ApiMethod(name = "tellAJoke")
    public MyBean tellAJoke(){

        Joke joke = new Joke();
        MyBean myBean = new MyBean();
        myBean.setMyJoke(joke.getJoke());
        return myBean;

    }

}
