const amqp = require('amqplib');

const RABBIT_URL = 'amqp://proyecto:losPerdidos123@localhost:5672';
const EXCHANGE = 'video_fragments';

async function connect() {
  const conn = await amqp.connect(RABBIT_URL);
  const channel = await conn.createChannel();

  await channel.assertExchange(EXCHANGE, 'fanout', {
    durable: false
  });

  return { conn, channel };
}

module.exports = { connect, EXCHANGE };