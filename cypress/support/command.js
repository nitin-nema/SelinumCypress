Cypress.Commands.add('login', (username, password) => {
  cy.request({
    method: 'POST',
    url: '/api/login',
    body: { username, password },
  }).then((resp) => {
    window.localStorage.setItem('authToken', resp.body.token);
  });
});


describe('Dashboard Access', () => {
  before(() => {
    cy.login('testuser', 'password123');
  });

  it('should access the dashboard', () => {
    cy.visit('/dashboard');
    cy.contains('Welcome to the Dashboard');
  });
});
