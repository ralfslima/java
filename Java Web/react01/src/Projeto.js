// Importar o módulo React
import React from 'react';

// Importar CSS
import './Projeto.css';

// Componente
class Projeto extends React.Component{

    // Construtor
    constructor(props){
        super(props);
        
        this.state = {
            nome : '',
            idade: '',
            vetor: []
        }
    }

    // Ao digitar o nome
    digitarNome = (e) => {
        this.setState({nome : e.target.value});
    }

    // Ao digitar a idade
    digitarIdade = (e) => {
        this.setState({idade : e.target.value});
    }

    // Ao clicar
    clicar = () => {
        
        // Objeto JSON
        var obj = {'nome':this.state.nome, 'idade':this.state.idade}

        // Criar um vetor vazio
        var copiaVetor = [];

        // Copiar os dados do vetor no state
        copiaVetor = [...this.state.vetor];

        // Adicionar um objeto
        copiaVetor.push(obj);

        // Atualizar vetor no state
        this.setState({vetor : copiaVetor});

        // Limpar os states nome e idade
        this.setState({
            nome : '',
            idade: ''
        })
    }

    // Remover registro
    remover = (e) => {

        // Copiar o vetor
        var copiaVetor = [];
        copiaVetor = [...this.state.vetor];

        // Remover dados do vetor
        copiaVetor.splice(e.target.value, 1);

        // Atualizar o vetor state
        this.setState({vetor : copiaVetor});

    }

    // Render
    render(){
        return(
            <div>
                
                {/* Formulário */}
                <form>
                    <input type='text' value={this.state.nome} onChange={this.digitarNome} placeholder='Informe seu nome' className='form-control' />
                    <input type='text' value={this.state.idade} onChange={this.digitarIdade} placeholder='Informe sua idade' className='form-control' />
                    <input type='button' onClick={this.clicar} value='Cadastrar' className='btn btn-primary' />
                </form>

                {/* Tabela */}
                <table className='table'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Idade</th>
                            <th>Remover</th>
                        </tr>
                    </thead>

                    <tbody>
                        {this.state.vetor.map((obj, indice) => {
                            return(
                                <tr>
                                    <td>{indice+1}</td>
                                    <td>{obj.nome}</td>
                                    <td>{obj.idade}</td>
                                    <td><button className='btn btn-danger' onClick={this.remover} value={indice}>Remover</button></td>
                                </tr>
                            );
                        })}
                    </tbody>
                </table>

            </div>
        );
    }

}

// Exportar o componente
export default Projeto;