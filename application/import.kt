var AdmZip = require('adm-zip');
const { join } = require('path');

function bootstrap() {
  const zip = new AdmZip();
  zip.addLocalFolder(join('.', 'assets'), 'assets');
  zip.addLocalFolder(join('.', 'images'), 'images');
  zip.addLocalFolder(join('.', 'scripts'), 'scripts');
  zip.addLocalFolder(join('.', 'styles'), 'styles', (name) =>
    name.includes('.css'),
  );
  zip.addLocalFile(join('.', 'manifest.json'));
  zip.addLocalFile(join('.', 'chapter.html'));
  zip.addLocalFile(join('.', 'hui.html'));
  zip.writeZip(join('.', 'webstore.zip'), () => {
    console.log('Zip build complete');
  });
}

bootstrap();
