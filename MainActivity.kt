import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val alunos = mutableListOf<Aluno>()
    private lateinit var adapter: AlunoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = AlunoAdapter(alunos)
        recyclerViewAlunos.layoutManager = LinearLayoutManager(this)
        recyclerViewAlunos.adapter = adapter

    
        val areas = listOf("Ciências", "Letras", "Matemática", "História")
        spinnerArea.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, areas)

       
        val dataFormatada = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        textViewData.text = "Data: $dataFormatada"

     
        buttonAdicionar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val area = spinnerArea.selectedItem.toString()
            if (nome.isNotEmpty()) {
                alunos.add(Aluno(nome, area))
                adapter.notifyDataSetChanged()
                editTextNome.text.clear()
                updateCount()
            }
        }

      
        buttonZerar.setOnClickListener {
            alunos.clear()
            adapter.notifyDataSetChanged()
            updateCount()
        }
    }

    private fun updateCount() {
        textViewContagem.text = "Quantidade de Alunos: ${alunos.size}"
    }
}
