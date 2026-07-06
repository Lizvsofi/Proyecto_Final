const { connect, EXCHANGE } = require('./rabbit');

async function listenFragments() {
  const { conn, channel } = await connect();

  const q = await channel.assertQueue('', { exclusive: true });

  channel.bindQueue(q.queue, EXCHANGE, '');

  console.log("nodo_b escuchando...");

  channel.consume(q.queue, (msg) => {
    const data = JSON.parse(msg.content.toString());

    console.log("nodo_b recibió:", data);
  }, { noAck: true });
}

module.exports = { listenFragments };