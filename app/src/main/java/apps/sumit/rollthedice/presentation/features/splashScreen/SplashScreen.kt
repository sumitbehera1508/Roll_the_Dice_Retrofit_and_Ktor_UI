package apps.sumit.rollthedice.presentation.features.splashScreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import apps.sumit.rollthedice.R
import apps.sumit.rollthedice.presentation.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(5f).getInterpolation(it)
                }
            )
        )
        delay(1000L)
        navController.navigate(Screen.MainScreenRoute.route) {
            popUpTo(Screen.SplashScreenRoute.route) {
                inclusive = true
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {


        Image(
            painter = painterResource(id = R.drawable.dice1),
            contentDescription = "logo",
            modifier = Modifier.scale(scale.value)
        )

    }

}