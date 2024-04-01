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
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class AuthLocalStorageTest {
    companion object{
        const val Token : String = "my Token"
    }

    lateinit var sut : AuthLocalStorage
    @Mock
    lateinit var context: Context
    @Mock
    lateinit var sharedPreference :SharedPreferences
    @Mock
    lateinit var editor: SharedPreferences.Editor

    @Before
    //configure l'envirenement de test
    fun setUp() {
        Mockito.`when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreference)
        Mockito.`when`(editor.putString(anyString(), anyString())).thenReturn(editor)
        Mockito.`when`(sharedPreference.getString(anyString(), anyString())).thenReturn(Token)
        Mockito.`when`(sharedPreference.edit()).thenReturn(editor)
        Mockito.`when`(editor.remove(anyString())).thenReturn(editor)
        sut = AuthLocalStorage(context)
    }

    @After
    fun tearDown() {
    }
    //Cette fonction test si sharedPreference exist
    //Cette fonction test si sharedpreference est initialiser
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
        Assert.assertEquals(expectedKey, AuthLocalStorage.SHARD_PREFERENCE_KEY)
        Assert.assertEquals(expectedMode, Context.MODE_PRIVATE)

    }
    @Test
    fun test_saveToken(){
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        //When
        sut.saveToken(Token)
        //Then
        verify(sharedPreference).edit()
        verify(editor).putString(tokenCaptor.capture(), tokenCaptor.capture())
        verify(editor).apply()

        val expectedKey : String = tokenCaptor.allValues[0]
        val expectedValue : String = tokenCaptor.allValues[1]
        Assert.assertEquals(expectedKey,AuthLocalStorage.TOKEN_KEY)
        Assert.assertEquals(expectedValue,Token)


    }
    @Test
    fun test_getToken_withNotSavedToken(){
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.`when`(sharedPreference.getString(anyString(), anyString())).thenReturn("")
        //When
        val result : String = sut.getToken()
        //Then
        verify(sharedPreference).getString(tokenCaptor.capture(), tokenCaptor.capture())
        //
        val expectedKey : String = tokenCaptor.allValues[0]
        val expectedDefaultValue : String = tokenCaptor.allValues[1]
        Assert.assertEquals(expectedKey,AuthLocalStorage.TOKEN_KEY)
        Assert.assertEquals(expectedDefaultValue,"")
        //
        Assert.assertEquals(result,"")

    }
    @Test
    fun test_getToken_withSavedToken(){
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        //When
        sut.saveToken(Token)
        val result : String = sut.getToken()
        //Then
        verify(sharedPreference).getString(tokenCaptor.capture(), tokenCaptor.capture())
        ////
        ////
        val expectedKey : String = tokenCaptor.allValues[0]
        val expectedDefaultValue : String = tokenCaptor.allValues[1]
        Assert.assertEquals(expectedKey,AuthLocalStorage.TOKEN_KEY)
        Assert.assertEquals(expectedDefaultValue, "")
        Assert.assertEquals(result, Token)

    }
    @Test
    fun test_clearToken(){
        //Given
        val tokenCaptor = ArgumentCaptor.forClass(String::class.java)
        Mockito.`when`(sharedPreference.getString(anyString(), anyString())).thenReturn("")
        //When
        sut.saveToken(Token)
        sut.clearToken()
        //Then
        verify(sharedPreference, times(2)).edit()
        verify(editor).remove(tokenCaptor.capture())
        verify(editor, times(2)).apply() //a comprendre
        val result = sut.getToken()
        ////
        val expectedKey : String = tokenCaptor.allValues[0]
        Assert.assertEquals(result,"")
        Assert.assertEquals(expectedKey,AuthLocalStorage.TOKEN_KEY)

    }
    @Test
    fun test_isLogged_withNotSavedToken(){
        //Given
        Mockito.`when`(sharedPreference.getString(anyString(), anyString())).thenReturn("")
        //When
        val result : Boolean = sut.isLogged()
        //Then
        verify(sharedPreference).getString(anyString(), anyString())
        Assert.assertFalse(result)
    }
    @Test
    fun test_isLogged_withSavedToken(){
        //Given

        //When
        sut.saveToken(Token)
        val result : Boolean = sut.isLogged()
        //Then
        verify(sharedPreference).getString(anyString(), anyString())
        Assert.assertTrue(result)
    }


}




