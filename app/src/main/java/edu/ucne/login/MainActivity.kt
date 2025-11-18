package edu.ucne.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.login.presentation.login.LoginViewModel
import edu.ucne.login.presentation.screen.LoginScreen
import edu.ucne.login.presentation.screen.RegisterScreen
import edu.ucne.login.ui.theme.LoginTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: LoginViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") {
                LoginScreen(
                    viewModel = viewModel,
                    onLoginSuccess = {
                        // Navegar a pantalla principal si quieres
                    },
                    onOpenRegister = { navController.navigate("register") }
                )
            }

            composable("register") {
                RegisterScreen(
                    viewModel = viewModel,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
