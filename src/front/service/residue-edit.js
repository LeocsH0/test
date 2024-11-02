// Arquivo: residue-edit.js

async function updateResidue(residueId, residueData) {
  try {
    // Checagem básica dos dados
    if (!residueId || !residueData.name || !residueData.type || !residueData.quantity || !residueData.location) {
      throw new Error("Todos os campos são obrigatórios.");
    }

    // Validação adicional (exemplo para quantidade)
    if (isNaN(residueData.quantity) || residueData.quantity <= 0) {
      throw new Error("A quantidade deve ser um número maior que zero.");
    }

    // Fazendo a requisição PUT para o back-end
    const response = await fetch(`https://seu-backend.com/api/residues/${residueId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(residueData)
    });

    // Tratamento de diferentes respostas HTTP
    if (response.status === 404) {
      throw new Error("Resíduo não encontrado.");
    } else if (response.status === 400) {
      throw new Error("Erro de validação: verifique os dados fornecidos.");
    } else if (!response.ok) {
      throw new Error("Erro ao atualizar o resíduo. Tente novamente mais tarde.");
    }

    // Verifica o JSON de resposta para mensagens do servidor
    const responseData = await response.json();
    if (responseData.success) {
      showMessage("Resíduo atualizado com sucesso!", "success");
    } else {
      throw new Error(responseData.message || "Erro desconhecido ao atualizar o resíduo.");
    }

  } catch (error) {
    // Exibe mensagens de erro para o usuário
    showMessage(error.message, "error");
  }
}

function showMessage(message, type) {
  const statusMessage = document.getElementById('statusMessage');
  statusMessage.textContent = message;
  statusMessage.style.color = type === "success" ? "green" : "red";
}

document.getElementById('editResidueForm').addEventListener('submit', async (e) => {
  e.preventDefault();

  const residueId = document.getElementById('residueId').value.trim();
  const residueData = {
    name: document.getElementById('residueName').value.trim(),
    type: document.getElementById('residueType').value.trim(),
    quantity: Number(document.getElementById('residueQuantity').value.trim()),
    location: document.getElementById('residueLocation').value.trim(),
  };

  // Chamando a função de atualização com os dados validados
  await updateResidue(residueId, residueData);
});
