describe('User Login', () => {
  before(() => {
    cy.fixture('user').as('userData');
  });

  it('should log in successfully', function () {
    cy.visit('/login');
    cy.get('input[name=username]').type(this.userData.username);
    cy.get('input[name=password]').type(this.userData.password);
    cy.get('button[type=submit]').click();

    cy.url().should('include', '/dashboard');
  });
});
