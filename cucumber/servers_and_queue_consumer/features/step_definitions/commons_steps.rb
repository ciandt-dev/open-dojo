Given(/^usuário logado "([^"]*)" e senha "([^"]*)"$/) do |arg1, arg2|
  visit "http://localhost:15672"
  first = first("input")
  if first[:name] == "username"
    fill_in "username", with: arg1
    fill_in "password", with: arg2
    click_on "Login"
  end
end

When(/^acessar a fila "([^"]*)"$/) do |arg1|
click_on "Queues"
click_on arg1
end

When(/^inserir o header "([^"]*)" igual a "([^"]*)"$/) do |arg1, arg2|
  if not find("#headers_1_mfkey", visible:false).visible?
    find("h2", text: "Publish message").click
  end
  fill_in "headers_1_mfkey", with: arg1
  fill_in "headers_1_mfvalue", with: arg2
end

When(/^postar conteúdo "([^"]*)" na fila dojo$/) do |arg1|
  fill_in "payload", with:arg1
  click_on "Publish message"
end

Then(/^recuperar arquivo "([^"]*)" com conteúdo "([^"]*)"$/) do |arg1, arg2|
  response = HTTParty.get "http://localhost:4567/api/#{arg1}"
  expect(response.body.chop).to eq(arg2)
end

Then(/^não recuperar arquivo "([^"]*)"$/) do |arg1|
out = HTTParty.get "http://localhost:4567/api/#{arg1}"
expect(out.response.code).to eq("404")
end

Then(/^verificar na fila "([^"]*)" o nome do arquivo "([^"]*)"$/) do |arg1, arg2|
  click_on "Queues"
  click_on arg1

  if not find("[name='count']", visible:false).visible?
    find("h2", text: "Get messages").click
  end
  click_on "Get Message(s)"
  teste=find(".msg-payload")
  expect(teste).to have_content arg2

end
