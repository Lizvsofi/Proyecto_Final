const { connect, EXCHANGE } = require('./rabbit');

async function listenFragments() {
  const { conn, channel } = await connect();

  const q = await channel.assertQueue('', { exclusive: true });

  channel.bindQueue(q.queue, EXCHANGE, '');

  console.log("nodo_a escuchando...");

  channel.consume(q.queue, (msg) => {
    const data = JSON.parse(msg.content.toString());

    console.log("nodo_a recibió:", data);
  }, { noAck: true });
}

module.exports = { listenFragments };