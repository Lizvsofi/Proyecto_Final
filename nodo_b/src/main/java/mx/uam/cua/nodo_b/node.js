const { publishFragment } = require('./publisher');
const { listenFragments } = require('./subscriber');

listenFragments();

// prueba automática
setTimeout(() => {
  publishFragment("curiosidades04.mp4");
}, 2000);