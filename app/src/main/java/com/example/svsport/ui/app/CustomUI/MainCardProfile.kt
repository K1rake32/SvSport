package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.app.data.AccountData
import com.example.svsport.ui.app.screens.Main.AccountDesign
import com.example.svsport.ui.app.screens.Main.accountList1
import com.example.svsport.ui.app.screens.Main.accountList2
import com.example.svsport.ui.theme.MainAppBar

@Composable
fun MainCardProfile(

    title: String,
    list: List<AccountData>

) {

    Card (

        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 6.dp

        ),

        colors = CardDefaults.cardColors(

            containerColor = Color.White

        )

    ) {

        Text(

            modifier = Modifier
                .padding(20.dp),

            text = title,
            style = MaterialTheme.typography.MainAppBar

        )

        LazyColumn(

            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp),

            verticalArrangement = Arrangement.spacedBy(10.dp),


        ) {

            items(list.size) { accountData ->

                AccountDesign(index = list[accountData], isSwitch = title == "Notification")

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun MainCardProfilePreview() {

    MainCardProfile("Notification", accountList2)

}
