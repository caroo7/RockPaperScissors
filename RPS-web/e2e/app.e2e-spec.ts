import { RPSWebPage } from './app.po';

describe('rps-web App', function() {
  let page: RPSWebPage;

  beforeEach(() => {
    page = new RPSWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
