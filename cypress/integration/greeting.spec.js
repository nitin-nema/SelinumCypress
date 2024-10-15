describe('Greeting API', () => {
  it('should return a greeting message', () => {
    cy.request('/api/greeting')
      .its('body')
      .should('equal', 'Hello, World!');
  });
});
