// Arquivo: residue-edit.js

document.getElementById('editResidueForm').addEventListener('submit', async (e) => {
  e.preventDefault();

  const residueId = document.getElementById('residueId').value;
  const residue = {
    name: document.getElementById('residueName').value,
    type: document.getElementById('residueType').value,
    quantity: document.getElementById('residueQuantity').value,
    location: document.getElementById('residueLocation').value,
  };

  try {
    const response = await fetch(`https://seu-backend.com/api/residues/${residueId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(residue)
    });

    if (response.ok) {
      document.getElementById('statusMessage').textContent = 'Resíduo atualizado com sucesso!';
      document.getElementById('statusMessage').style.color = 'green';
    } else {
      throw new Error('Erro ao atualizar o resíduo');
    }
  } catch (error) {
    document.getElementById('statusMessage').textContent = 'Erro ao atualizar o resíduo.';
    document.getElementById('statusMessage').style.color = 'red';
  }
});
