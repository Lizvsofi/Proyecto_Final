const { connect, EXCHANGE } = require('./rabbit');

async function publishFragment(fragment) {
    const { conn, channel } = await connect();

    const msg = JSON.stringify({
        fragment,
        node: 'nodo_b'
    });

    channel.publish(EXCHANGE, '', Buffer.from(msg));

    console.log("nodo_b envió:", msg);

    setTimeout(() => conn.close(), 500);
}

module.exports = { publishFragment };