describe('Product Search Testing', () => {
  it('should display search results for valid product', () => {
    cy.visit('/http:www.amazon.com');


    cy.get('#searchBar').type('Laptop');
    cy.get('#searchButton').click();
     cy.get('.prodyuct-list').should('have.length.greaterThan',0);
    cy.get('.prodyuct-list').should('be.visible').and('contain', 'Laptop');
  });
});