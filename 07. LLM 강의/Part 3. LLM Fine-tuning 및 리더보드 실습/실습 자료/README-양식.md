---
language:
- ko
datasets: 
- [...dataset_repo...]
library_name: transformers
pipeline_tag: text-generation
license: [...model_license...]
---

# **[...your_model_name...]**  

## Model Details   
**Model Developers**  
- [...your_name...]

**Model Architecture**  
- [...your_model_name...] is an auto-regressive language model based on the LLaMA2 transformer architecture.  

**Base Model**   
- [...base_model...](repo_link)   

**Training Dataset**   
- [...dataset_repo...](repo_link)  

---  
# Model comparisons1
> Ko-LLM leaderboard(11/23; [link](https://huggingface.co/spaces/upstage/open-ko-llm-leaderboard))
   
| Model | Average | Ko-ARC | Ko-HellaSwag | Ko-MMLU | Ko-TruthfulQA | Ko-CommonGen V2 |
| --- | --- | --- | --- | --- | --- | --- |
| **[...your_model_name...]** | NaN | NaN | NaN | NaN | NaN | NaN | 
  
---  
# Model comparisons2
> AI-Harness evaluation; [link](https://github.com/Beomi/ko-lm-evaluation-harness)   
   
| Model | Copa | Copa | HellaSwag | HellaSwag | BoolQ | BoolQ | Sentineg | Sentineg |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
|  | 0-shot | 5-shot | 0-shot | 5-shot | 0-shot | 5-shot | 0-shot | 5-shot |
| **[...your_model_name...]** | NaN | NaN | NaN | NaN | NaN | NaN | NaN | NaN |
  
---
# Implementation Code
```python
### KO-Platypus
from transformers import AutoModelForCausalLM, AutoTokenizer
import torch

repo = "[...your_model_repo...]"
OpenOrca = AutoModelForCausalLM.from_pretrained(
        repo,
        return_dict=True,
        torch_dtype=torch.float16,
        device_map='auto'
)
OpenOrca_tokenizer = AutoTokenizer.from_pretrained(repo)
```

---
