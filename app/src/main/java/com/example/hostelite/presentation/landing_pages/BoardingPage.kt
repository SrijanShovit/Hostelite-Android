package com.example.hostelite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.min

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BoardingPage(onNavigateToLogin: () -> Unit){
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .fillMaxSize()
    ) {
        if(pagerState.currentPage != 2){
            IconButton(
                onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage+1)
                        }
                },
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .then(Modifier.size(50.dp))
                    .clip(CircleShape)
                    .background(Color(0xFF9C32A6))
                    .align(Alignment.BottomEnd),
                content = { forwardButton() },
            )
        }
        else{
            TextButton(
                onClick = { onNavigateToLogin() },
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                modifier = Modifier
                    .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                    .fillMaxWidth(0.75f)
                    .background(color = Color(0xFF9C32A6))
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "Get Started",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }
        }

        mainContent(pagerState, coroutineScope)
        TextButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(2)
                }}){
            Text(
                text = AnnotatedString("Skip"),
                style = TextStyle(
                    color = Color(0xFF645B5B),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                )
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun mainContent(pagerState: PagerState, coroutineScope: CoroutineScope){
    val painters : List<Painter> = listOf(
        painterResource(id = R.drawable.bs1),
        painterResource(id = R.drawable.bs2),
        painterResource(id = R.drawable.bs3)
    )

    val primaryTexts : List<String> = listOf(
        "Solve your Issues",
        "Fast & Easy!",
        "Keep Track!"
    )

    val secondaryTexts : List<String> = listOf(
        "Contact  to authorities whenever you have any complaints.",
        "Now you can mark your entry and exit in just a tap.",
        "Now keep track of hostelites with our enhanced location tracker ."
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(count = 3, state = pagerState) { page ->
            when (page) {
                0 -> {
                    pagerContent(painters[0], primaryTexts[0], secondaryTexts[0])
                }
                1 -> {
                    pagerContent(painters[1], primaryTexts[1], secondaryTexts[1])
                }
                2 -> {
                    pagerContent(painters[2], primaryTexts[2], secondaryTexts[2])
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Indicators(pagerState.currentPage)
    }
}

@Composable
fun Indicators(pageNo: Int){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Dots(0 == pageNo)
        Dots(1 == pageNo)
        Dots(2 == pageNo)
    }
}

@Composable
fun Dots(isCurrent: Boolean){
    var modifier: Modifier = Modifier

    if(isCurrent){
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth(0.2f)
            .size(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF9C32A6))
    }
    else{
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .size(10.dp)
            .clip(CircleShape)
            .background(Color(0xFF9C32A6))
    }

    Box(modifier = modifier)
}
@Composable
fun pagerContent(painter: Painter, primaryText: String, secondaryText: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(width = 200.dp, height = 200.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = primaryText,
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = secondaryText,
            style = TextStyle(
                color = Color(0xFF484848),
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center
            )
        )
    }

}
@Composable
fun forwardButton() : Unit{
    Icon(
        painter = painterResource(id = R.drawable.ic_forward_arrow),
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier.size(35.dp)
    )
}