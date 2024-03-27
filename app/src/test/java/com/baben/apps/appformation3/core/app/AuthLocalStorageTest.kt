package com.baben.apps.appformation3.core.app

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import com.baben.apps.appformation3.core.app.AuthLocalStorage.Companion.SHARED_PREFERENCE_KEY
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthLocalStorageTest {
    lateinit var sut : AuthLocalStorage
    @Mock
    lateinit var context: Context
    @Mock
    lateinit var mockSharedPreferences: SharedPreferences
    @Before
    fun setUp() {


        `when`(context.getSharedPreferences(any(String::class.java), any(Int::class.java))).thenReturn(mockSharedPreferences)
        sut = AuthLocalStorage(context)
        //
        //MockitoAnnotations.initMocks(this)

        //val sharedPreferences = Mockito.mock(SharedPreferences::class.java)
        //`when`(context.getSharedPreferences("AuthPrefs", Context.MODE_PRIVATE)).thenReturn(sharedPreferences)

        //sut = AuthLocalStorage(context)
        //
        //val context = ApplicationProvider.getApplicationContext<Context>()
         //sut = AuthLocalStorage(context)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_shredPreference_initialised(){
        val argument= ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(context).getSharedPreferences(argument.capture(), any(Int::class.java))
        assertNotNull(mockSharedPreferences)
        assertEquals(SHARED_PREFERENCE_KEY,argument.value)

    }
    @Test
    public fun saveTokenTest(){
        val token = "jeton_test"
        sut.saveToken(token)
        val jetonRécupéré = sut.getToken()
        assertEquals(token, jetonRécupéré)

    }
    @Test
    fun getTokenTest(){
        sut.saveToken(null)
        val jetonRécupéré = sut.getToken()
        assertNull(jetonRécupéré)
    }
    @Test
    fun userLoggedInTest(){
        sut.saveToken("test_token")
        assertTrue(sut.isLoggedIn())
        sut.saveToken(null)
        assertFalse(sut.isLoggedIn())
    }


}