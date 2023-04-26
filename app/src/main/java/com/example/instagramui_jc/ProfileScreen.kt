package com.example.instagramui_jc

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "deepsheth7781", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonSection()
        Spacer(modifier = Modifier.height(10.dp))
        HighLightSection(highlights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.youtube),
                text = "YouTube"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.qa),
                text = "Q&A"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.discord),
                text = "Discord"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.telegram),
                text = "Telegram"
            ),
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
            )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(imageWithTexts = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.ic_grid),
                text = "posts"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_reels),
                text = "reels"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_igtv),
                text = "igtv"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.profile),
                text = "Profile"
            )

        )){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0-> PostSection(postList = listOf(
                painterResource(id = R.drawable.kmm),
                painterResource(id = R.drawable.intermediate_dev),
                painterResource(id = R.drawable.master_logical_thinking),
                painterResource(id = R.drawable.bad_habits),
                painterResource(id = R.drawable.multiple_languages),
                painterResource(id = R.drawable.learn_coding_fast),
                painterResource(id = R.drawable.kmm),
                painterResource(id = R.drawable.intermediate_dev),
                painterResource(id = R.drawable.master_logical_thinking),
                painterResource(id = R.drawable.bad_habits),
                painterResource(id = R.drawable.multiple_languages),
                painterResource(id = R.drawable.learn_coding_fast),
            ), modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun TopBar(
    name:String,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ){
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis, // it will end the name with ... if it is longer than the space assigned
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(100.dp))
        Icon(painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier.size(24.dp)
        )
        //Spacer(modifier = Modifier.width(20.dp))
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier.size(24.dp)
        )
    }

}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(image = painterResource(id = R.drawable.deep)
                ,modifier = Modifier
                    .size(90.dp)
                    .weight(3f) //30% of whole row width
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Deep Sheth",
            description = "EAT-CODE-GYM-SLEEP-REPEAT",
            url = "https://www.deepjodd.com",
            followedBy = listOf("maahi7781","virat.kohli"),
            otherCount = 69
        )
        
    }

}

@Composable
fun RoundImage(
    image : Painter,
    modifier: Modifier = Modifier
) {
    Image(painter = image,
        contentDescription = null,
        modifier= modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true /*it will first check the height of the image and then adjust width same as height and if it is false the it will first check width and then set height according to it*/
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
    
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "69" , text = "Posts")
        ProfileStat(numberText = "69M" , text = "Followers")
        ProfileStat(numberText = "69" , text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText : String,
    text:String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = numberText, fontWeight = FontWeight.Bold , fontSize = 20.sp )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName:String,
    description:String,
    url:String,
    followedBy :List<String>,
    otherCount:Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by ")
                followedBy.forEachIndexed { index, s ->
                    pushStyle(boldStyle)
                    append(s)
                    pop()
                    if(index < followedBy.size-1) {
                        append(", ")
                    }
                }
                if(otherCount>2){
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
                letterSpacing = letterSpacing,
                lineHeight= lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier= Modifier.fillMaxWidth()
) {
    val minimumWidth  = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minimumWidth, height)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minimumWidth, height)
                .height(height)
        )
        ActionButton(
            text = "Email",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minimumWidth, height)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(height)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text : String? = null,
    icon : ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text!=null){
            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if(icon!=null){
            Icon(imageVector = icon, contentDescription = null , tint = Color.Black)
        }
    }
}

@Composable
fun HighLightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end=15.dp)
            ) {
                RoundImage(image = highlights[it].image,modifier = Modifier.size(50.dp))
                Text(text = highlights[it].text , overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts : List<ImageWithText>,
    onTabSelected: (selectedIndex:Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inActiveColor = Color(0xFF777777)
    TabRow(selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ){
        imageWithTexts.forEachIndexed{
            index,item ->

            Tab(selected = selectedTabIndex==index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedTabIndex=index
                    onTabSelected(index)
                }) {
                Icon(painter=item.image, contentDescription = item.text , tint = if(selectedTabIndex==index) Color.Black else inActiveColor, modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)

                )
            }
        }

    }
}

@Composable
fun PostSection(
    postList:List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.scale(1.01f) // in order to push the borders of posts outside screen
    ){
        items(postList.size){
            Image(painter = postList[it], contentDescription = null , contentScale = ContentScale.Crop ,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }

}