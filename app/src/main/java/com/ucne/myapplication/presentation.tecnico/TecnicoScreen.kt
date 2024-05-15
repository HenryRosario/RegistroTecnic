package com.ucne.myapplication.presentation.tecnico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ucne.myapplication.data.local.entities.TecnicoEntity
import com.ucne.myapplication.data.local.entities.TicketEntity
import com.ucne.myapplication.presentation.ticket.TicketViewModel
import com.ucne.roomdemo.ui.theme.RoomDemoTheme

@Composable
fun TecnicoScreen(
    viewModel: TecnicoViewModel
) {
    val tecnicos by viewModel.tecnicos.collectAsStateWithLifecycle()
    TecnicoBody(
        onSaveTecnico = { tecnico ->
            viewModel.saveTecnico(tecnico)
        }
    )
}

@Composable
fun TecnicoBody(onSaveTecnico: (TecnicoEntity) -> Unit) {
    var tecnicoId by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var saldoHora by remember { mutableStateOf(0) }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {


            OutlinedTextField(
                label = { Text(text = "Nombre") },
                value = nombre,
                onValueChange = { nombre = it },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                label = { Text(text = "SaldoHora") },
                value = saldoHora.toString(), // Convertido a cadena de texto
                onValueChange = { saldoHora = it.toIntOrNull() ?: 0 }, // Convertido a entero o 0 si es nulo
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(2.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(
                    onClick = {
                        tecnicoId = ""
                        nombre = ""
                        saldoHora = 0
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "new button"
                    )
                    Text(text = "Nuevo")
                }
                OutlinedButton(
                    onClick = {
                        onSaveTecnico(
                            TecnicoEntity(
                                tecnicoId = tecnicoId.toIntOrNull(),
                                nombre = nombre,
                                saldoHora =  saldoHora.toString()
                            )
                        )
                        tecnicoId = ""
                        nombre = ""
                        saldoHora = 0
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "save button"
                    )
                    Text(text = "Guardar")
                }
            }
        }

    }

}


@Preview
@Composable
private fun TecnicoPreview() {
    RoomDemoTheme {
        TecnicoBody() {
        }
    }
}