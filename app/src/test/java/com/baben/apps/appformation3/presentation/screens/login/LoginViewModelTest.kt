package com.baben.apps.appformation3.presentation.screens.login

import android.content.Context
import android.content.SharedPreferences
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.anyString
import org.mockito.Mockito.`when`
import org.mockito.kotlin.verify


class LoginViewModelTest {
    lateinit var lvm : LoginViewModel
    @Mock
    lateinit var context: Context
    @Before
    fun setUp() {
        lvm = LoginViewModel(context)
    }
    @After
    fun tearDown() {
    }
    @Test
    fun testLoginSuccess() {
        //Given
        //wHEN
        //Then

    }






}