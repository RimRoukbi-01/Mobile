package com.baben.apps.appformation3.presentation.screens.login

import android.content.Context
import android.content.SharedPreferences
import com.baben.apps.appformation3.core.app.AuthLocalStorage
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.verify

class LoginViewModelTest {
    lateinit var lvm : LoginViewModel
    @Mock
    lateinit var sharedPreference : SharedPreferences
    @Mock
    lateinit var context: Context
    @Before
    fun setUp() {
        Mockito.`when`(context.getSharedPreferences(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(sharedPreference)
        lvm = LoginViewModel(context)
    }
    @After
    fun tearDown() {
    }
    @Test
    fun test_sharedPreference_initialized(){
        //Given:vous configurez les préconditions nécessaires pour le test
        //utilisation des captors (keyCaptor et modeCaptor) pour capturer les arguments passés à
        // la méthode getSharedPreferences() et vérifier s'ils correspondent aux valeurs attendues
        val keyCaptor = ArgumentCaptor.forClass(String::class.java)
        val modeCaptor = ArgumentCaptor.forClass(Int::class.java)
        //When:kandiro fiha dakchi li 3an3ytolo
        //Then
        verify(context).getSharedPreferences(keyCaptor.capture(), modeCaptor.capture())
        //vérifier que l'objet sharedPreference n'est pas nul
        Assert.assertNotNull(sharedPreference)
        val expectedKey : String = keyCaptor.value
        val expectedMode : Int = modeCaptor.value
        Assert.assertEquals(expectedKey, LoginViewModel.SHARD_PREFERENCE_KEY)
        Assert.assertEquals(expectedMode, Context.MODE_PRIVATE)

    }
    @Test
    fun test_ValidUserName() {
       //Given
        val username : String = "my name"
        //When
        val result : Boolean = lvm.ValidUserName(username)
        //Then


    }






}