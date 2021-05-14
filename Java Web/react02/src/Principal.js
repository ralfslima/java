// Importar módulo React
import React from 'react';

// Importar CSS
import './Principal.css';

// Classe
export default class Principal extends React.Component{

    // Construtor
    constructor(props){
        super(props);

        this.state = {
            clientes : [],
            codigo : '',
            nome : '',
            idade: '',
            alterar : false,
            corMensagem : '',
            txtMensagem : ''
        }
    }

    // Antes de realizar o Render
    componentDidMount(){
        fetch('http://localhost:8085/api/clientes')
        .then(retorno => retorno.json())
        .then(retorno => this.setState({clientes : retorno}))
    }

    // Ao Digitar
    aoDigitar = (e) => {
        this.setState({ [e.target.name] : e.target.value });
    }

    // Cadastrar
    cadastrar = () => {

        if(this.state.nome === ""){
            this.setState({
                txtMensagem : 'O nome precisa ser peeenchido',
                corMensagem : 'vermelho'
            });
        }else if(this.state.idade === ""){
            this.setState({
                txtMensagem : 'A idade precisa ser peeenchida',
                corMensagem : 'vermelho'
            });
        }else{
            this.setState({
                txtMensagem : 'Cadastro efetuado com sucesso',
                corMensagem : 'verde'
            });

            fetch(
                'http://localhost:8085/api/clientes',
                {
                    method : 'POST',
                    headers:{
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    },
                    body: JSON.stringify({'nome':this.state.nome, 'idade':this.state.idade})
                }
            )
            .then(retorno => retorno.json())
            .then(retorno => {

                // Cópia do vetor de clientes
                let copiaClientes = this.state.clientes;

                // Adicionar o novo cliente
                copiaClientes.push(retorno);

                // Sobrescrever o state clientes com a cópia do vetor
                this.setState({clientes : copiaClientes});

                // Limpar campos
                this.setState({
                    nome : '',
                    idade: ''
                });

            })

        }
    }

    // Selecionar
    selecionar = (e) => {
        let codigo = e.target.value;

        fetch('http://localhost:8085/api/clientes/'+codigo)
        .then(retorno => retorno.json())
        .then(retorno => {
            this.setState({
                codigo : retorno.codigo,
                nome   : retorno.nome,
                idade  : retorno.idade,
                alterar : true,
                corMensagem : '',
                txtMensagem : ''
            });
        });
    }

    // Reset
    cancelar = () => {

        this.setState({
            codigo : '',
            nome   : '',
            idade  : '',
            alterar: false,
            corMensagem : '',
            txtMensagem : ''
        });

    }

    // Remover
    remover = () => {

        fetch(
            'http://localhost:8085/api/clientes/'+this.state.codigo,
            {
                method : 'DELETE',
                headers:{
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
            }
        ).then(() => {

            // Cópia do state de clientes
            let copiaVetor = [...this.state.clientes];

            // Filtrar
            copiaVetor = copiaVetor.filter((objeto) => {
                return objeto.codigo !== this.state.codigo;
            });

            // Sobrepor o state clientes
            this.setState({clientes : copiaVetor});

            // Reset
            this.cancelar();

            // Mensagem
            this.setState({
                txtMensagem : 'Cliente removido com sucesso',
                corMensagem : 'verde'
            });

        });

    }

    // Alterar
    alterar = () => {

        if(this.state.nome === ""){
            this.setState({
                txtMensagem : 'O nome precisa ser peeenchido',
                corMensagem : 'vermelho'
            });
        }else if(this.state.idade === ""){
            this.setState({
                txtMensagem : 'A idade precisa ser peeenchida',
                corMensagem : 'vermelho'
            });
        }else{

            fetch(
                'http://localhost:8085/api/clientes',
                {
                    method : 'PUT',
                    headers:{
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    },
                    body: JSON.stringify({'codigo':this.state.codigo, 'nome':this.state.nome, 'idade':this.state.idade})
                }
            )
            .then(retorno => retorno.json())
            .then(retorno => {

                // Cópia do vetor
                let copiaVetor = [...this.state.clientes];

                // Percorrer o vetor para obter o índice a ser alterado
                let indiceAlteracao = copiaVetor.findIndex((obj) => {
                    return obj.codigo === this.state.codigo;
                });

                // Alterar o copiaVetor
                copiaVetor[indiceAlteracao] = retorno;
                
                // Sobrepor o state clientes
                this.setState({clientes : copiaVetor});
                
                // Reset
                this.cancelar();

                // Mensagem
                this.setState({
                    txtMensagem : 'Alteração realizada com sucesso',
                    corMensagem : 'verde'
                });

            });

        }

    }

    // Render
    render(){
        return(
            <main>

                <form>
                    <div className={
                        this.state.corMensagem === 'vermelho' ? 'alert alert-danger' :
                        this.state.corMensagem === 'verde' ? 'alert alert-success' : 
                        ''
                    }>{this.state.txtMensagem}</div>

                    <input type='text' name='nome' value={this.state.nome} onChange={this.aoDigitar} placeholder='Nome' className='form-control' />
                    <input type='text' name='idade' value={this.state.idade} onChange={this.aoDigitar} placeholder='Idade' className='form-control' />
                    
                    {this.state.alterar === false ?
                        <input type='button' value='Cadastrar' onClick={this.cadastrar} className='btn btn-primary' />
                    :
                        <div>
                            <input type='button' value='Alterar' onClick={this.alterar} className='btn btn-warning' />
                            <input type='button' value='Remover' onClick={this.remover} className='btn btn-danger' />
                            <input type='button' value='Cancelar' onClick={this.cancelar} className='btn btn-secondary' />
                        </div>
                    }   
                        
                </form>

                <table className='table table-striped table-dark'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Idade</th>
                            <th>Selecionar</th>
                        </tr>
                    </thead>

                    <tbody>
                        {this.state.clientes.map((objeto, indice) => {
                            return(
                                <tr key={indice}>
                                    <td>{objeto.codigo}</td>
                                    <td>{objeto.nome}</td>
                                    <td>{objeto.idade}</td>
                                    <td><button className='btn btn-success' value={objeto.codigo} onClick={this.selecionar}>Selecionar</button></td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>

            </main>
        );
    }

}