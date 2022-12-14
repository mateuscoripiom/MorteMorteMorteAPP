# MorteMorteMorteAPP

<strong>ETEC PROF. Basilides de Godoy<br>
2º DESENVOLVIMENTO DE SISTEMAS ETIM<br>
Programação de Aplicativos Mobile – Profª. Aline Firmino<br>
Integrantes: Leonardo Mazzuco e Mateus Coripio

Aplicativo do filme Morte, Morte, Morte

Link para o vídeo de demonstração do app (armazenamento): https://youtu.be/-gaOabaxtE4<br>
Link para o vídeo de demonstração do app (somente app): https://www.youtube.com/watch?v=qrAUEFMuYn0

No filme, jovens se reúnem em uma mansão para jogar um jogo de detetive-assassino, mas corpos reais começam a aparecer. 
Assim como nele, decidimos criar o aplicativo com a função de sortear quem seriam os jogadores e quem seriam os assassinos. Além disso, também incluímos informações sobre o filme.</strong>

Quantidade total de Activities: 19 + classe helper para o banco de dados<br>
<a href="https://imgur.com/AeMAvSh"><img src="https://i.imgur.com/AeMAvSh.png" title="source: imgur.com" /></a>

<h1>Armazenamento</h1>

- Saved Instance e Armazenamento Interno: ambos foram usados na tela de crítica. Nesta tela, o usuário pode escrever sua pequena crítica sobre o filme de salvar ela no app. O texto digitado no EditText é salvo para um arquivo Critica.txt e depois você pode lê-lo quando quiser.<br>
<a href="https://imgur.com/Fwof2NR"><img src="https://i.imgur.com/Fwof2NR.jpg" title="source: imgur.com" width=25%/></a>
<a href="https://imgur.com/9wgf19w"><img src="https://i.imgur.com/9wgf19w.jpg" title="source: imgur.com" width=25% /></a>
<br>
- Shared Preferences: usado na tela de palpite. A tela serve para você usar depois de ver a tela de personagens. Antes de você ver o filme, vai na tela de personagens e escolha alguém para julgar como assassino do filme e vá para a tela de palpite e escreva o nome. Após você ver o filme, você volta na tela e revele qual havia sido o seu palpite.<br>
<a href="https://imgur.com/fOVo4rA"><img src="https://i.imgur.com/fOVo4rA.jpg" title="source: imgur.com" width=25%/></a>
<a href="https://imgur.com/OYs4gV2"><img src="https://i.imgur.com/OYs4gV2.jpg" title="source: imgur.com" width=25% /></a>
<br>
- Armazenamento Externo: usado na tela de conheça o filme. Há uma pequena galeria de imagens onde você pode baixar as imagens para o seu celular. As imagens ficam salvas em uma pasta chamada Pictures do armazenamento do dispositivo. Você também pode visualizá-la na galeria.<br>
Para este, também foi implementado no AndroidManifest.xml as permissões para uasr o armazenamento externo.<br>
<a href="https://imgur.com/j23uZt4"><img src="https://i.imgur.com/j23uZt4.jpg" title="source: imgur.com" width=25%/></a>
<a href="https://imgur.com/IWlD2Cf"><img src="https://i.imgur.com/IWlD2Cf.jpg" title="source: imgur.com" width=25% /></a>
<a href="https://imgur.com/HeNrCza"><img src="https://i.imgur.com/HeNrCza.jpg" title="source: imgur.com" width=25% /></a>

<br>
- Banco de Dados Local ( SQLite): usado no login. Você pode se cadastrar e logar no aplicativo através do pequeno ícone de usuário na tela inicial. Lá, o usuário pode se logar direto, ou então se cadastrar caso não tenha login.<br>
<a href="https://imgur.com/9Iq04ij"><img src="https://i.imgur.com/9Iq04ij.jpg" title="source: imgur.com" width=20%/></a>
<a href="https://imgur.com/Pz2LgXh"><img src="https://i.imgur.com/Pz2LgXh.jpg" title="source: imgur.com" width=20%/></a>
<a href="https://imgur.com/WHYUyb6"><img src="https://i.imgur.com/WHYUyb6.jpg" title="source: imgur.com" width=20%/></a>
<a href="https://imgur.com/1ftAQ2Y"><img src="https://i.imgur.com/1ftAQ2Y.jpg" title="source: imgur.com" width=20%/></a>


<h1>APP Geral</h1>

Uso de arquivos strings.xml. Todos os textos que estão presentes no aplicativo, estão sendo usados a partir do arquivo de strings.<br>
<a href="https://imgur.com/srXN87M"><img src="https://i.imgur.com/srXN87M.png" title="source: imgur.com" width=700px/></a>
 

Intents explícitas: Existem diversas intents explícitas na aplicação para a navegação.
Como por exemplo, o botão de menu presente em quase todas as telas, e o próprio menu que tem intents para a navegação dentro do app.<br>
<a href="https://imgur.com/40R8yff"><img src="https://i.imgur.com/40R8yff.png" title="source: imgur.com" /></a>
 


Intents implícitas: Existem pelo menos 4 intents implícitas diferentes no app.
- Pesquisa na internet<br>
<a href="https://imgur.com/gr8dv9W"><img src="https://i.imgur.com/gr8dv9W.png" title="source: imgur.com" /></a><br>
O botão de cinemas próximas na tela inicial é uma intent implícita para pesquisar na internet.

- Acessar link na internet já definido<br>
<a href="https://imgur.com/8EbVqAH"><img src="https://i.imgur.com/8EbVqAH.png" title="source: imgur.com" /></a> <br>
O botão de assistir ao trailer na tela de conhecer mais sobre o filme é uma intent implícita para acessar um link da internet.

- Email<br>
<a href="https://imgur.com/pS5ktvK"><img src="https://i.imgur.com/pS5ktvK.png" title="source: imgur.com" /></a><br>
O botão para mandar um email na tela de personagens é uma intent implícita para enviar um email. O propósito do botão é para dar um palpite de que quem é o assassino no filme, após você ver e analisar os personagens.

- Acessar localização no mapa de coordenada já definida<br>
<a href="https://imgur.com/QLIBQWO"><img src="https://i.imgur.com/QLIBQWO.jpg" title="source: imgur.com" width=250px /></a><br>
O botão de acessar a localização na tela de créditos é uma intent implícita para visualizar no mapa coordenadas já definidas. 

Sensor: Temos uso do sensor de acelerometro linear na tela de jogadores e na tela de assassino. O propósito dele é agitar o celular linearmente para ligar a lanterna, que faz parte do jogo.

Acessar a localização: O aplicativo tem acesso a sua localização através do ACCESS_COARSE_LOCATION. Assim que o aplicativo já é aberto, ele pergunta se você aceita a permissão de localização que o app pede.

<strong>Telas:</strong><br>
Tela inicial -
a tela inicial serve mais como uma apresentação do filme. Nele podemos ver uma foto promocional do filme, a logo e um botão para acessar os cinemas próximos a você. Também nessa tela vamos ter um botão com uma intent explícita para acessar a segunda activity, que é a tela de menu.<br>
Views na tela – TextView, ImageView, Switch, Button, 

Tela do menu - 
Todas as telas do app, com exceção de duas, tem algum botão com uma intent explícita que traz até a tela de menu. Nela, vamos poder visualizar as 6 principais activities do app.<br>
Views na tela – Button, TextView, ImageView

Tela de conheça o filme – 
Esta tela serve para você se aprofundar mais nas informações gerais sobre o filme. Temos como ver duas opções diferentes de poster, temos a sinopse, botão para assistir ao trailer e uma galeria de imagens.<br>
Views na tela – TextView, ImageView, Button, RadioGroup, RadioButton, ScrollView

Tela de personagens –
Esta tela serve para você conhecer mais sobre os personagens do filme. Temos uma imagem, nome e descrição de cada um. Após analisar todos os personagens, temos um botão para você poder mandar um email com um palpite de quem você acha que é o assassino dentro da história do filme.<br>
Views na tela – TextView, ImageView, cardView, Button, ScrollView

Tela de sorteio –
Nesta tela, o usuário vai poder realizar o sorteio com o seu grupo de amigos para saber quem são os assassinos e quem são os jogadores. Ele pode digitar um número de jogadores entre 5 e 15. Cada pessoa deve clicar no botão de sortear sem a outra olhar, vai surgir na tela uma mensagem se você é o assassino ou jogador, e após isso, quando a mensagem sumir da tela, o jogador deve passar o celular para o outro realizar o seu sorteio. É importante lembrar que um jogador não pode ver o resultado do outro. <br>
Views na tela – TextView, Button, cardView, ImageView, 

Tela de regras/jogo –
Clicando para acessar a tela de jogo, você vai acessar primeiro a tela de regras. Nela, estarão bem detalhadas todas as regras do jogo. Após isso, você pode ir direto para o jogo. Clicando no botão de iniciar, você vai cair em uma tela onde deve clicar se você é o assassino ou se é jogador. <br>
Views da tela de regras – ScrollView, TextView, cardView, Button<br>
Views da tela de jogo – Button, TextView

Tela de jogador/assassino – 
A tela de jogador e assassino são duas telas diferentes, mas são basicamente a mesma coisa. Na tela de jogador, vamos ter um botão para marcar a quantidade de corpos que você encontrou no caminho, é somente uma anotação mesmo para você ter uma ideia, mas este dado não ficará salvo, também temos um botão para ligar a lanterna e um botão caso você tenha sido assassinado. Na tela de assassino a única coisa que muda é que invés de um botão de corpos encontrados, é um botão para quantidade de pessoas que você matou e invés do botão para caso você tenha sido assassinado, é um botão para caso você tenha sido descoberto.<br> 
Importante lembrar que aqui também entra o sensor. A lanterna pode ser ligada tanto pelo botão quanto pelo sensor de acelerômetro, balançando o celular de um lado para o outro.<br>
Views nas telas – Button, TextView, ImageView

Tela de descoberto/assassinado/ganhou – 
São três activities diferentes, mas que tem o mesmo propósito e formato. Cada uma serve para identificar se você foi descoberto no jogo, ganhou no jogo ou foi assassinado. Claro que só são possíveis chegar nelas caso você tenha apertado o botão se tiver perdido, se tiver morrido etc.<br>
Views nas telas – cardView, TextView, Button

Tela de créditos –
Nesta tela, é onde ficam os créditos da diretora do filme, do elenco do filme, mostra também onde foram realizadas as gravações do filme, que inclusive tem um botão para acessar o local exato no mapa. Também temos intents implícitas para acessar o IMDb dos atores e da diretora, assim como o Instagram da diretora e o do estúdio do filme.<br>
Views nas telas – ScrollView, ImageView, Button, cardGroup, TextView

Tela da WebView –
Nesta tela, temos somente a WebView, que é para o acesso a partir do link da intent implícita de acessar link da internet.
