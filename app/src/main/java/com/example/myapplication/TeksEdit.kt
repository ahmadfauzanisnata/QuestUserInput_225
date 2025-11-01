package com.example.myapplication



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val listGender = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFB388FF), Color.White)
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(top = 60.dp, start = 16.dp, end = 16.dp)
        ) {


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {

                    Text(
                        text = "Formulir Pendaftaran",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7C4DFF),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        textAlign = TextAlign.Center
                    )


                    Text(
                        text = "NAMA LENGKAP",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        placeholder = { Text("Isian nama lengkap") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    Text(
                        text = "JENIS KELAMIN",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    listGender.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (jenisKelamin == item),
                                    onClick = { jenisKelamin = item }
                                )
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (jenisKelamin == item),
                                onClick = { jenisKelamin = item }
                            )
                            Text(text = item)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = "STATUS PERKAWINAN",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    listStatus.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (status == item),
                                    onClick = { status = item }
                                )
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (status == item),
                                onClick = { status = item }
                            )
                            Text(text = item)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = "ALAMAT",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        placeholder = { Text("Alamat") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))


                    Button(
                        onClick = { /* aksi submit */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E40FF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(text = "Submit", color = Color.White, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}
