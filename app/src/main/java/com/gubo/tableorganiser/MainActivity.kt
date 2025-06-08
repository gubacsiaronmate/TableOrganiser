package com.gubo.tableorganiser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gubo.tableorganiser.model.ObjectBox
import com.gubo.tableorganiser.model.Person
import com.gubo.tableorganiser.ui.screens.SettingsScreen
import com.gubo.tableorganiser.ui.screens.TableScreen
import com.gubo.tableorganiser.ui.theme.TableOrganiserTheme
import io.objectbox.Box
import io.objectbox.BoxStore

class MainActivity : ComponentActivity() {
    private val store: BoxStore by lazy { ObjectBox.store }
    val personBox: Box<Person> by lazy { ObjectBox.getPersonBox() }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ObjectBox.init(this)
        enableEdgeToEdge()
        setContent {
            TableOrganiserTheme {
                AppNavHost()
            }
        }
    }
    
    @Composable fun AppNavHost() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { TableScreen(navController, personBox) }
            composable("importJson") { SettingsScreen(personBox) }
        }
    }
}