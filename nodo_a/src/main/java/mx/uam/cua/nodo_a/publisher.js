const { connect, EXCHANGE } = require('./rabbit');

async function publishFragment(fragment) {
  const { conn, channel } = await connect();

  const msg = JSON.stringify({
    fragment,
    node: 'nodo_a'
  });

  channel.publish(EXCHANGE, '', Buffer.from(msg));

  console.log("nodo_a envió:", msg);

  setTimeout(() => conn.close(), 500);
}

module.exports = { publishFragment };