const { publishFragment } = require('./publisher');
const { listenFragments } = require('./subscriber');

listenFragments();

// prueba automática
setTimeout(() => {
  publishFragment("curiosidades01.mp4");
}, 2000);