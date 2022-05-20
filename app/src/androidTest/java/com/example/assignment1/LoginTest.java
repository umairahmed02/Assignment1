package com.example.assignment1;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.ContentView;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginTest extends TestCase {

    EditText username, password;
    ImageView button;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void LoginTest(){
    }

    @After
    public void tearDown() throws Exception {
    }
}