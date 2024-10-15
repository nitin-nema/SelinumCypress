describe('Mocking API Responses', () => {
  it('should show an error message for failed API call', () => {
    cy.intercept('GET', '/api/data', { statusCode: 500 }).as('getData');
    cy.visit('/data-page');
    cy.wait('@getData');

    cy.get('.error-message').should('be.visible').and('contain', 'Failed to load data');
  });
});
