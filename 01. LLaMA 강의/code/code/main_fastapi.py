from fastapi import FastAPI
import torch
from transformers import LlamaForCausalLM, AutoTokenizer


# Initialize instance of FastAPI
app = FastAPI()


# load tokenizer
tokenizer = AutoTokenizer.from_pretrained("../daily_tokenizer_0612")

# load model
device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
model = LlamaForCausalLM.from_pretrained('../llama_combined_0618')
model.to(device)


def get_answer(prompt):
    #prompt = """Return True if the given article is fake. article: Boeing CEO says he assured Trump about Air Force One costs answer:"""

    inputs = tokenizer(prompt, return_tensors="pt")
    inputs.to(device)

    # Generate
    generate_ids = model.generate(inputs.input_ids, max_length=inputs.input_ids.shape[1]+5)
    output = tokenizer.batch_decode(generate_ids, skip_special_tokens=True, clean_up_tokenization_spaces=False)[0]
    output = output[len(prompt):]

    return(output)

@app.get('/')
async def root():
    return {'message': 'Hello World'}


@app.get('/chat_test')
async def test(user_message):
    return {'message': get_answer(user_message)}


@app.post('/chat')
async def chat(param: dict={}):
   user_message = param.get('user_message', ' ')
   return {'message': get_answer(user_message)}
 
