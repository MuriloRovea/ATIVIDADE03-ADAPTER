import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunoAdapter(private val alunos: List<Aluno>) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNome: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.textViewNome.text = "${aluno.nome} - ${aluno.area}"
    }

    override fun getItemCount(): Int {
        return alunos.size
    }
}
