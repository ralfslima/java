import React from 'react';

class App extends React.Component{

  // Construtor
  constructor(props){
    
    // Executar o construtor do props
    super(props);

    // Variável dinâmica
    this.state = {
      nome : 'Ralf',
      contador : 0,
      vetor : [
        {'nome':'Ana'  , 'cidade':'Blumenau'},
        {'nome':'Bruno', 'cidade':'Joinville'},
        {'nome':'Carla', 'cidade':'Brusque'}
      ]
    }

  }

  // Função de mensagem
  mensagem = () => {
    alert('Aprendendo ReactJS!');
  }

  // Função para incrementar o contador
  incrementar = () => {
    var cont = this.state.contador;

    cont++;

    this.setState({contador:cont});
  }
  
  // Exibir uma estrutura HTML
  render(){
    return(
      <div>
        <h1>Boa noite {this.state.nome}</h1>
        <h1>A multiplicação é {5*5}</h1>
        <button onClick={this.mensagem}>Clique aqui</button>
        
        <hr/>
      
        <h1>{this.state.contador == 0 ? "Não houve cliques" : this.state.contador}</h1>
        <button onClick={this.incrementar}>Adicionar +1</button>

        <hr/>

        <table>
          {this.state.vetor.map((objeto) => {
            return(
              <tr>
                <td>{objeto.nome}</td>
                <td>{objeto.cidade}</td>
              </tr>
            );
          })}
        </table>

      </div>
    );
  }

}

export default App;