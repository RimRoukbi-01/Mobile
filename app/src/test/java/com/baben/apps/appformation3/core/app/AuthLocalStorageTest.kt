package com.baben.apps.appformation3.core.app
import android.content.Context
import android.content.SharedPreferences
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class AuthLocalStorageTest {

    lateinit var sut : AuthLocalStorage
    @Mock
    lateinit var context: Context
    @Mock
    lateinit var sharedPreference :SharedPreferences

    @Before
    //configure l'envirenement de test
    fun setUp() {
        Mockito.`when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreference)
        sut = AuthLocalStorage(context)
    }

    @After
    fun tearDown() {
    }
    //Cette fonction test si sharedPreference exist
    //Cette fonction test si sharedpreference est initialiser
    @Test
    fun test_sharedPreference_initialized(){
        //Given
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
        Assert.assertEquals(expectedKey, AuthLocalStorage.SHARD_PREFERENCE_KRY)
        Assert.assertEquals(expectedMode, Context.MODE_PRIVATE)

    }
    @Test
    fun test_saveToken(){
        //Given
        val Token : String = "my Token"
        //When
        sut.saveToken(Token)
        //Then
    }


}


