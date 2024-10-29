import { ColetaService } from './coleta-service.js';

const coletaService = new ColetaService();

document.getElementById('editResidueForm').addEventListener('submit', async (e) => {
  e.preventDefault();

  const residueId = 1;  // Este valor pode ser dinâmico, dependendo da lógica do app
  const residue = {
    id: residueId,
    name: document.getElementById('residueName').value,
    type: document.getElementById('residueType').value,
    quantity: document.getElementById('residueQuantity').value,
    location: document.getElementById('residueLocation').value,
  };

  try {
    const updatedResidue = await coletaService.putResiduo(residue);
    document.getElementById('statusMessage').textContent = 'Resíduo atualizado com sucesso!';
    document.getElementById('statusMessage').style.color = 'green';
  } catch (error) {
    document.getElementById('statusMessage').textContent = 'Erro ao atualizar o resíduo.';
    document.getElementById('statusMessage').style.color = 'red';
  }
});
